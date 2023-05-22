package com.github.hrozhek.signistserviceauth.service;

import com.github.hrozhek.signistserviceauth.repo.ClientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;



}
