package com.example.scutaru.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class ConnectionServiceImpl {

	private BufferedReader getDataFromScript(String command) throws IOException {

		Process process = Runtime.getRuntime().exec(command);
		return new BufferedReader(new InputStreamReader(process.getInputStream()));
	}

	public String getParamFromLine(String command) throws IOException {
		return this.getDataFromScript(command).readLine();

	}
}
