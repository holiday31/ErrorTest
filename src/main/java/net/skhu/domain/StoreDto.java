package net.skhu.domain;

import lombok.Data;

@Data
public class StoreDto {
    String name;
    double latitude;
    double longitude;
    String address;
}
