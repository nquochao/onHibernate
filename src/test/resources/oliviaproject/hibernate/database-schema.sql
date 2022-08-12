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

Reinitialisation with @OneToMany foreignkey:

drop table OneToManyChessBoardPreference cascade constraints;
drop table OneToManyUserName cascade constraints;

select * from OneToManyChessBoardPreference ;
select * from OneToManyUserName;


Reinitialisation with @OneToMany and ManyToOne:


drop table OneToManyBiDirChessBoardPreference  cascade constraints;
drop table OneToManyBiDirUserName cascade constraints;

select * from OneToManyBiDirChessBoardPreference  ;
select * from OneToManyBiDirUserName;