package me.jovi.hellospring.service.impl;

import me.jovi.hellospring.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joyce on 2017/6/29.
 */
@Service(value = "permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {
}
