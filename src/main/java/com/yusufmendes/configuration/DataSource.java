package com.yusufmendes.configuration;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataSource {

    private String url;
    private String username;
    private String password;
}
