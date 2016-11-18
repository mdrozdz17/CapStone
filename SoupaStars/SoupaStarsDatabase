drop database if exists SoupaStars;

create database SoupaStars;

create table if not exists SoupaStars.Post
(PostID int not null auto_increment,
Title varchar(50) not null,
PostYear int not null,
PostMonth varchar(10) not null,
PostDay int not null,
Author varchar(50) not null,
PostBody varchar(999999) not null,
Category varchar(50) not null,
primary key (PostID) );

create table if not exists SoupaStars.PostComment
(PostID int not null, CommentID int);

use SoupaStars;
Insert into PostComment (PostID, CommentID) values(1,1);

create table if not exists SoupaStars.Comments
(CommentID int not null,
userName varchar(50) not null,
email varchar(50),
commentDate varchar(50),
primary key (CommentID));

insert into Comments (CommentID, userName, email, commentDate)
	values(1, 'LiamL', 'email@gmail.com', 'November 31st');
use SoupaStars;

Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(1,'Test Post 1', 2016, 'November', 21, 'Liam Long', 'asdfjkla;sdf;alksjdf','Cooking Fails');

select * from Post;
select * from PostComment;
select * from Comments;
