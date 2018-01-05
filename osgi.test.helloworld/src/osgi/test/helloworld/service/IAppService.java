package osgi.test.helloworld.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAppService extends Remote {

	/** 
     * 得到一个远程服务的名称 . 
     * @return . 
     * @throws RemoteException . 
     */ 
    String getAppName() throws RemoteException; 
}
