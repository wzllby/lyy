package org.example.service;

import org.example.exception.CommException;

public interface IExcelService {
    void saveInfo(String fileName) throws CommException;
}
