create table orderDetail(
    order_id int,
    customer_name varchar(50),
    email varchar(50),
    shipping_address varchar(100),
    id int references orderItem(product_id),
    total_amount float,
    order_date date,
    status status,
    primary key (order_id)
)