Reinitialisation with @OneToOne jointable:
drop table jointableusername cascade constraints;
drop table jointablechessboardpreference cascade constraints;
drop table USERNAME_CHESSBOARDPREFERENCE cascade constraints;

;
select * from jointableusername;
select * from jointablechessboardpreference;
select * from JOINTABLE_USERNAME_CHESSBOARDPREFERENCE;

Reinitialisation with @OneToOne foreignkey:
drop table foreignkeyusername cascade constraints;
drop table foreignkeychessboardpreference cascade constraints;
select * from foreignkeyusername;
select * from foreignkeychessboardpreference;
