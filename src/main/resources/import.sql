INSERT INTO Player(player_id,username,age) VALUES (nextval('player_player_id_seq'),'jure',4);
INSERT INTO Player(player_id,username,age) VALUES (nextval('player_player_id_seq'),'matic',2);
INSERT INTO Player(player_id,username,age) VALUES (nextval('player_player_id_seq'),'matic',5);
INSERT INTO Player(player_id,username,age) VALUES (nextval('player_player_id_seq'),'citam',5);

INSERT INTO Problem(problem_id,problems,player_id_fk) VALUES (nextval('problem_problem_id_seq'),[],2);

INSERT INTO SolutionStep(solution_step_id,onOff,ordering,solution_id_fk) VALUES (nextval('solutionstep_solution_step_id_seq'),1,4,4,1);




alter sequence player_player_id_seq restart with 5;
alter sequence problem_problem_id_seq restart with 2;
alter sequence solution_solution_id_seq restart with 2;
alter sequence solutionstep_solution_step_id_seq restart with 2;