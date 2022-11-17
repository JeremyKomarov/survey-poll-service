package com.pollService.userService;

import com.pollService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "UserService",
        url = "${internalApi.userApi.url}"
)
public interface UserService {
    @GetMapping(value = "/user/{userId}")
    User getUserById(@PathVariable Long userId);
}