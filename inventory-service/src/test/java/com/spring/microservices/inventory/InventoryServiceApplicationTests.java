package com.spring.microservices.inventory;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

//@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Thiết lập môi trường kiểm thử với cổng ngẫu nhiên
class InventoryServiceApplicationTests {
    @ServiceConnection // Sử dụng Testcontainers để kết nối với MySQL, testcontainer là một thư viện giúp quản lý các container trong quá trình test
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");

    @LocalServerPort // Lấy cổng ngẫu nhiên mà ứng dụng đang chạy
    private Integer port;

    @BeforeEach 
    void setup() {
        RestAssured.baseURI = "http://localhost";  // Thiết lập base URI cho RestAssured để gửi yêu cầu đến ứng dụng đang chạy
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

	@Test
	void isInStock_return200_Ok() {
				String skuCode = "iphone_15";
				Integer quantity = 100;
				RestAssured.given()
								.queryParam("skuCode", skuCode)
								.queryParam("quantity", quantity)
								.when()
								.get("/api/inventory")
								.then()
								.log().all()
								.statusCode(200)
								.body(Matchers.equalTo("true")); // Kiểm tra rằng sản phẩm có trong kho
	}

}
