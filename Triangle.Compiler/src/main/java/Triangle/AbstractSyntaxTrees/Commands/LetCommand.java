/*
 * @(#)LetCommand.java                        2.1 2003/10/07
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

package Triangle.AbstractSyntaxTrees.Commands;

import Triangle.AbstractSyntaxTrees.Declarations.Declaration;
import Triangle.AbstractSyntaxTrees.Visitors.CommandVisitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public class LetCommand extends Command {

	public LetCommand(Declaration dAST, Command cAST, SourcePosition position) {
		super(position);
		D = dAST;
		C = cAST;
	}

	public <TArg, TResult> TResult visit(CommandVisitor<TArg, TResult> v, TArg arg) {
		return v.visitLetCommand(this, arg);
	}

	public final Declaration D;
	public final Command C;
}