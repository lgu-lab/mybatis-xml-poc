CREATE TYPE color_enum AS ENUM ('red', 'green', 'blue'); 

-- range : {red,green,blue}
SELECT enum_range(NULL::color_enum)

-- rows 
SELECT unnest(enum_range(NULL::color_enum))

-- red
SELECT enum_first(null::color_enum);

-- blue
SELECT enum_last(null::color_enum);


CREATE TABLE shape (
    id int,
    color color_enum 
);

-- OK
INSERT INTO shape VALUES (1, 'red'); 
INSERT INTO shape VALUES (2, 'green'); 
INSERT INTO shape VALUES (11, 'red'); 
INSERT INTO shape VALUES (333, 'blue'); 
-- Case sensitive : BLUE invalid 
-- INSERT INTO shape VALUES (334, 'BLUE'); 

-- ERROR : invalid color_enum : foo
-- INSERT INTO shape VALUES (1, 'foo' ); 

select * from shape ; 
select * from shape where color = 'red' ; 

-- ERROR : invalid color_enum : foo
-- select * from shape where color = 'foo' ; 


CREATE CAST (varchar AS color_enum) WITH INOUT AS IMPLICIT;

CREATE TABLE schema1.client (
	id int4 NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	age int4 NOT NULL,
	CONSTRAINT client_pkey PRIMARY KEY (id)
);
