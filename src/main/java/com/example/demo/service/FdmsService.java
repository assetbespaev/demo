package com.example.demo.service;

import com.example.demo.dto.FdmsChangePasswordByLoginResponse;
import java.rmi.RemoteException;

public interface FdmsService {

  FdmsChangePasswordByLoginResponse changePasswordByLoginResult(int taskId) throws RemoteException;

}
