package com.spring.microservices.productserivce;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;


@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Chạy ứng dụng trong môi trường ngẫu nhiên, không cần phải chỉ định cổng
class ProductSerivceApplicationTests {

    @ServiceConnection // Sử dụng Testcontainers để kết nối với MongoDB, testcontainer là một thư viện giúp quản lý các container trong quá trình test
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort // Lấy cổng ngẫu nhiên mà ứng dụng đang chạy
    private Integer port;

    @BeforeEach 	// Thiết lập trước mỗi test case
    void setup() {
        RestAssured.baseURI = "http://localhost"; //RestAssured là một thư viện giúp kiểm thử API RESTful
        RestAssured.port = port;
    }
    static {
        mongoDBContainer.start();
    }

	@Test
	void createProduct_return201Created() {
        String requestBody = """
                {
                    "name": "Iphone 16",
                    "description": "New Iphone",
                    "price": 16000000
                }
                """;
        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("api/product")
                .then()
                .statusCode(201 )
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("Iphone 16"))
                .body("description", Matchers.equalTo("New Iphone"))
                .body("price", Matchers.equalTo(16000000));
	}

}
