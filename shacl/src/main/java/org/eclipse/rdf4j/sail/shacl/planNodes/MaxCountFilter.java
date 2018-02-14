/*******************************************************************************
 * Copyright (c) 2016 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/

package org.eclipse.rdf4j.sail.shacl.planNodes;


import org.eclipse.rdf4j.model.Literal;

public class MaxCountFilter extends FilterPlanNode {

	private final long maxCount;

	public MaxCountFilter(PlanNode parent, PushBasedPlanNode trueNode, PushBasedPlanNode falseNode, long maxCount) {
		super(parent, trueNode, falseNode);
		this.maxCount = maxCount;
	}

	@Override
	boolean checkTuple(Tuple t) {
		Literal literal = (Literal) t.line.get(1);
		return literal.longValue() <= maxCount;
	}

}
