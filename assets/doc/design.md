# Design Model

## คำอธิบาย

ออกแบบการเลือกซื้อสินค้าและชำระด้วยบัตรเครดิต มี model สำหรับเก็บข้อมูล ดังต่อไปนี้

## WorkFlow

- customer search สินค้าที่ต้องการซื้อด้วยชื่อ
- customer เจอสินค้าที่อยากและได้เห็นรายละเอียดของสินค้า
- customer add สินค้าลงตะกร้า
  - customer อาจเปลี่ยนใจ remove สินค้าออกจากตะกร้าได้
  - customer อาจเปลี่ยนใจ add สินค้าเพิ่มได้
- customer เช็ึครายะเอียดสินค้าที่อยู่ในตะกร้าก่อน checkout
- customer ชำระสินค้า
- customer ใส่ที่อยู่ในการจัดส่งสินค้า
- customer ชำระสินค้าด้วยบัตรเครดิตแล้วกรอกข้อมูลของบัตร
- customer กดชำระสินค้าแล้วโชว์ผลการชำระเงิน ที่อยู่ ของ customer

## ER Diagram

![er-diagram](../img/er-diagram.jpeg)

## Feature

- ค้นหา product ด้วยชื่อของสินค้า
- บันทึกข้อมูลที่อยู่การจัดส่ง
- บันทึกบัตรเครดิต โดยจะมีการเข้ารหัสข้อมูลบัตรเอาไว้
- เพิ่ม / ลด สินค้าจากตะกร้าได้
- checkout เพื่อทำการชำระสินค้า

## Endpoint

| method | url                                | Description                       | Sample Valid Request Body                           | Sample Valid Response Body                              |
| ------ | -----------------------------------| ----------------------------------| ----------------------------------------------------|---------------------------------------------------------|
| POST   | /customers/addCreditCard           | เพิ่มบัตรเครดิต                       | [JSON](../sample/request/addCreditCard.json)        | [JSON](../sample/response/addCreditCard.json)           |
| POST   | /customers/addShippingAddress      | เพิ่มที่อยู่ในการจัดส่งสินค้า               | [JSON](../sample/request/addShippingAddress.json)   | [JSON](../sample/response/addShippingAddress.json)      |
| GET    | /orders/lastest?customerId={id}    | ดึงประวัติการสั่งซื้อล่าสุดของ customerId  | Query Param                                         | [JSON](../sample/response/getOrderLastest.json.json)    |
| GET    | /orders/{orderId}                  | ดึงข้อมูลประวัติการสั่งซื้อตาม orderId     | Path variable                                       | [JSON](../sample/response/getOrderById.json)            |
| GET    | /products/search?keyword={keyword} | ดึงรายการสินค้าที่มี keyword            | Query Param                                         | [JSON](../sample/response/searchProduct.json)           |
| POST   | /carts/addToCart                   | เพิ่มสินค้าเข้าตะกร้า                   | [JSON](../sample/request/addToCart.json)            | [JSON](../sample/response/addToCart.json)               |
| POST   | /carts/removeFromCart              | ลบสินค้าออกจากตะกร้า                 | [JSON](../sample/request/removeFromCart.json)       | [JSON](../sample/response/removeFromCart.json)          |
| GET    | /carts?customerId= {id}            | ดึงข้อมูลตะกร้าสินค้าของ customerId     | Query Param                                         | [JSON](../sample/response/getAllItemInCart.json)        |
| GET    | /carts/getSummary?customerId= {id} | ดึงข้อมูลสรุปราคาสินค้าก่อนชำระเงิน       | Query Param                                         | [JSON](../sample/response/getSummary.json)              |
| POST   | /carts/checkout                    | ทำการชำระสินค้า                     | [JSON](../sample/request/checkout.json)             | [JSON](../sample/response/checkout.json)