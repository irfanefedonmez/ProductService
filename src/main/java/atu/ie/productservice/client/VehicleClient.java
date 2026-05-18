package atu.ie.productservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "vehicle-service", url = "http://localhost:8081")
public interface VehicleClient {

    @GetMapping("/api/vehicles")
    String getVehicles();
}