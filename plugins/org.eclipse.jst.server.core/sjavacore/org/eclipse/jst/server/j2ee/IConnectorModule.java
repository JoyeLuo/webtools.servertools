/**********************************************************************
 * Copyright (c) 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *    IBM - Initial API and implementation
 **********************************************************************/
package org.eclipse.jst.server.j2ee;

import org.eclipse.core.runtime.IPath;
/**
 * A J2EE connector module.
 */
public interface IConnectorModule extends IJ2EEModule {
	/**
	 * Returns the classpath as an array of absolute IPaths.
	 * 
	 * @param the classpath array
	 */
	public IPath[] getClasspath();
}