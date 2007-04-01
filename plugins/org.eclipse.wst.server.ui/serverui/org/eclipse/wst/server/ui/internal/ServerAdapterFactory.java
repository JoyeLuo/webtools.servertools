/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.ui.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IActionFilter;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.wst.server.core.IServer;
/**
 * Adapter factory to adapt servers to IActionFilter.
 */
public class ServerAdapterFactory implements IAdapterFactory {
	IActionFilter actionFilter = new IActionFilter() {
		public boolean testAttribute(Object target, String name, String value) {
			return ServerPropertyTester.checkProperty(target, name, value);
		}
	};
	
	IWorkbenchAdapter workbenchAdapter = new IWorkbenchAdapter() {
		public Object[] getChildren(Object o) {
			return null;
		}

		public ImageDescriptor getImageDescriptor(Object object) {
			return ImageResource.getImageDescriptor(ImageResource.IMG_SERVER);
		}

		public String getLabel(Object o) {
			if (o instanceof IServer)
				return ((IServer) o).getName();
			return null;
		}

		public Object getParent(Object o) {
			return null;
		}
	};

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IActionFilter.class)
			return actionFilter;
		
		if (adapterType == IWorkbenchAdapter.class)
			return workbenchAdapter;
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class[] getAdapterList() {
		return new Class[] { IActionFilter.class, IWorkbenchAdapter.class };
	}
}