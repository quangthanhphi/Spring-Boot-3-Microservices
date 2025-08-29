package com.spring.microservices.order;

import com.spring.microservices.order.stubs.InventoryClientStub;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;


import static org.hamcrest.MatcherAssert.assertThat; // Import các phương thức assertThat từ Hamcrest để kiểm tra điều kiện trong bài kiểm tra

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0) // port = 0 để WireMock tự động chọn cổng trống, WireMock dùng để mô phỏng
class OrderServiceApplicationTests {

    @ServiceConnection // Sử dụng Testcontainers để kết nối với MySQL, testcontainer là một thư viện giúp quản lý các container trong quá trình test
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort // Lấy cổng ngẫu nhiên mà ứng dụng đang chạy
    private Integer port;

    @BeforeEach // Phương thức này sẽ được gọi trước mỗi bài kiểm tra
    void setup() {
        RestAssured.baseURI = "http://localhost"; 
        RestAssured.port = port;
    }

    static { // Khởi động MySQL container trước khi chạy các bài kiểm tra
        mySQLContainer.start();
    }

	@Test 
	void placeOrder_return201Created() { 
        String orderJson = """
                {
                    "price": 2000,
                    "quantity": 1,
                    "skuCode": "iphone_15"
                }
                """;
        InventoryClientStub.stubInventoryCall("iphone_15",1);

        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .body(orderJson)
                .when()
                .post("/api/order")
                .then()
                .log().all() // In ra log của response để kiểm tra
                .statusCode(201)
                .extract() // Trích xuất body của response
                .body().asString(); 

        assertThat(responseBodyString, Matchers.is("Order Created Successfully")); //asert rằng phản hồi là "Order Created Successfully"
	}

}
