insert into parameters (id, name, description, value) values (1, 'license-agreement', 'acuerdos de uso de', 'orem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac lacus et mi porttitor ullamcorper vitae eleifend arcu. Nulla vel posuere ante. Nulla quam mauris, volutpat ac dolor nec, aliquet accumsan nisi. Etiam vestibulum auctor sem non viverra. Donec erat neque, aliquam et urna eu, sodales finibus mauris. Maecenas tristique libero at odio rhoncus, vitae tristique ex rutrum. Maecenas suscipit nibh nec dui vehicula, id consectetur orci lobortis. Maecenas a tellus velit. Donec sodales consectetur augue, id condimentum massa mattis sit amet. Phasellus sit amet placerat neque. Sed tincidunt eu felis sit amet porta. Curabitur velit turpis, eleifend vel felis pharetra, accumsan tempus tortor.');

insert into recommendations (id, description) values (1, 'recomendacion 1');
insert into recommendations (id, description) values (2, 'recomendacion 2');
insert into recommendations (id, description) values (3, 'recomendacion 3');
insert into recommendations (id, description) values (4, 'recomendacion 4');

insert into procedures(code, name) values ('001', 'procedure 1');
insert into procedures(code, name) values ('002', 'procedure 2');
insert into procedures(code, name) values ('003', 'procedure 3');

insert into procedures_types(id, name, examples, pnr) values (1, 'Intenso', 'Cirugia de Torax - Columna', 90);
insert into procedures_types(id, name, examples, pnr) values (2, 'Alto', 'Laparotomia - Colelap - Apendictomia', 50)
insert into procedures_types(id, name, examples, pnr) values (3, 'Medio', 'Mastoide - Timpano - Blefaropastia', 40)
insert into procedures_types(id, name, examples, pnr) values (4, 'Sedacion', 'Litotripsia', 15)
insert into procedures_types(id, name, examples, pnr) values (5, 'Microcirugia', 'Reseccion de Tumor de Hipofisis', 50)