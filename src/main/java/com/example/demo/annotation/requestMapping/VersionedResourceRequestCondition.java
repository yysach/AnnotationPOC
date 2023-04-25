/*
 * $Copyright: Copyright (c) 2017 Veritas Technologies LLC. All rights reserved VT25-0977-2658-84-51-3 $
 */

package com.example.demo.annotation.requestMapping;

import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.AbstractRequestCondition;

public class VersionedResourceRequestCondition extends AbstractRequestCondition<VersionedResourceRequestCondition> {

    private Integer fromVersion;

    public VersionedResourceRequestCondition(int from) {
    	this.fromVersion = from;
    }

    @Override
    public VersionedResourceRequestCondition combine(VersionedResourceRequestCondition other) {
    	System.out.println("under combine method...");
        	/*
           * VersionedResource annotation is allowed only at method level.
           * So, there shouldn't be any case for combine.
           */
    	return new VersionedResourceRequestCondition(fromVersion);
    }

    @Override
    public VersionedResourceRequestCondition getMatchingCondition(HttpServletRequest request) {
    	System.out.println("inside getMatchingCondition");
    	Integer headerFrom = Integer.parseInt(request.getHeader("configId"));
    	System.out.println("Request Parameter : " + request.getParameter("configId"));
    	System.out.println("received fromVersion from header is : " + headerFrom);
    	System.out.println("fromVersion set at annotation condition is  : " + this.fromVersion);
    	if(headerFrom >= this.fromVersion) {
    		return this;
    	}
        return null;
    }

    @Override
    public int compareTo(VersionedResourceRequestCondition other, HttpServletRequest request) {
        /*
         * Compare this condition to another condition in the context of a specific request.
         * This method assumes both instances have been obtained via getMatchingCondition(HttpServletRequest)
         * to ensure they have content relevant to current request only.
         *
         * For our use case, we do not want multiple instances passing getMatchingCondition.
         * So, we would return 0 - which would indicate to spring that both the conditions are applicable.
         * In which case, spring would flag it as conflicting specification resulting in exception.
         */
    	System.out.println("Inside of VersionRequestMappingHandler compareTo..");
        return 0;
    }

    @Override
    protected Collection<?> getContent() {
        /*
         * Return the discrete items a request condition is composed of.
         */
    	System.out.println("from getContent " + fromVersion);
        return (fromVersion == null) ? Collections.emptyList() : Collections.singletonList(fromVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VersionedResource={");
        if (fromVersion != null) {
            sb.append(String.valueOf(fromVersion));
        }
        sb.append("}");
        System.out.println("api versionedResourced : " + sb.toString());
        return sb.toString();
    }

    @Override
    protected String getToStringInfix() {
        /*
         * The notation to use when printing discrete items of content.
         */
        return " || ";
    }
}