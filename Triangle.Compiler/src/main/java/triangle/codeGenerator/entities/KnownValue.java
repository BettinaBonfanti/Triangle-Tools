/*
 * @(#)KnownValue.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package triangle.codeGenerator.entities;

import triangle.abstractMachine.OpCode;
import triangle.abstractSyntaxTrees.vnames.Vname;
import triangle.codeGenerator.Emitter;
import triangle.codeGenerator.Frame;

public class KnownValue extends RuntimeEntity implements FetchableEntity {

	private final int value;

	public KnownValue(int size, int value) {
		super(size); // size is the amount of memory taken up by this value
		this.value = value; // the value itself
	}

	public final int getValue() {
		return value;
	}

	//is used to generate the machine code that’s used whenever this value is needed
	public void encodeFetch(Emitter emitter, Frame frame, int size, Vname vname) {
		// presumably offset = 0 and indexed = false
		emitter.emit(OpCode.LOADL, 0, value); // It simply calls LOADL to load the literal value onto the stack.
	}
}