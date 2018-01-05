package osgi.test.helloworld.impl;

import java.rmi.RemoteException;

import org.osgi.framework.BundleContext;

import osgi.test.helloworld.service.IAppService;

public class DefaultAppServiceImpl implements IAppService {

	public DefaultAppServiceImpl(BundleContext context) {

	}

	@Override
	public String getAppName() throws RemoteException {
		return "DefaultAppServiceImpl";
	}

}
