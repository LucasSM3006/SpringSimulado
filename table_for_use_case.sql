create table product(
	product_id serial primary key,
	title varchar(50),
	description varchar(100),
	production_price float,
	sale_price float,
	category varchar(50),
	availability boolean
);

create table batch(
	batch_id serial primary key,
	name varchar(50),
	batch_date date,
	product int,
	foreign key (product) REFERENCES product (product_id)
)

drop table product, batch;

alter table product
	rename column availability to available;
	
select * from product;

delete from product;