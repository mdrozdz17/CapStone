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

create table if not exists SoupaStars.PostTag
(PostID int not null, TagID int);

insert into PostTag (PostID, TagID)
	values(1,1);

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
	values(1,'How not to use Sriracha', 2016, 'November', 21, 'Liam Long', 'Number 1: Ketchup','Cooking Fails');
Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(2,"Use ovenmits, kids", 2016, 'November', 22, 'Chris Bartley', 'Ovens are hot.','Miscellaneous');
Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(3,'Why pie is objectively better than cake', 2016, 'November', 17, 'Matt Drozdz', 'It just is.','Pretentious Pedagogy');
Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(4, 'How the Cinammon Challenge changed my life', 2016, 'October', 29, 'Alyssa Rice', 'Cinammon is dangerous.','Food Challenges');

create table if not exists SoupaStars.Tag
(TagID int not null,
TagBody varchar(50),
primary key (TagID));

insert into Tag (TagID, TagBody) values (1,'Tag Text');
create table if not exists SoupaStars.User
(UserID int auto_increment not null,
Username varchar(50) not null,
UserPassword varchar(20) not null,
primary key (UserID));

Insert into User (UserID, Username, UserPassword)
	values(1, 'LiamL', 'password');
select * from Post;
select * from PostComment;
select * from PostTag;
select * from Comments;
select * from Tag;
select * from User;
