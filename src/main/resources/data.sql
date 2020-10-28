INSERT INTO category (description) VALUES ('American');
INSERT INTO category (description) VALUES ('Italian');
INSERT INTO category (description) VALUES ('Mexican');
INSERT INTO category (description) VALUES ('Japanese');
INSERT INTO category (description) VALUES ('Fast Food');
INSERT INTO unit_of_measure (description) VALUES ('Teaspoon');
INSERT INTO unit_of_measure (description) VALUES ('Tablespoon');
INSERT INTO unit_of_measure (description) VALUES ('Cup');
INSERT INTO unit_of_measure (description) VALUES ('Pinch');
INSERT INTO unit_of_measure (description) VALUES ('Whole');
INSERT INTO unit_of_measure (description) VALUES ('Each');
INSERT INTO unit_of_measure (description) VALUES ('Dash');
INSERT INTO unit_of_measure (description) VALUES ('Pint');
INSERT INTO recipe (description, prep_time, servings, url) VALUES ('How to Make Perfect Guacamole', 10, 4,'https://www.simplyrecipes.com/recipes/perfect_guacamole/');
INSERT INTO note (recipe_notes, recipes_id) VALUES ('1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.',1);
UPDATE recipe SET notes_id = 1 where id = 1;
INSERT INTO ingredient (amoung, description, recipe_id, uom_id) VALUES (4, 'Avocados',1,5)