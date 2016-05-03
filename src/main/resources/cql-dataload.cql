create table message_sent (from_user text, to_user text, sent_at timestamp, delivered boolean, content text, PRIMARY KEY (from_user, to_user, sent_at, delivered));
create table message_recieved (to_user text, from_user text, recieved_at timestamp, opened boolean, content text, PRIMARY KEY (to_user, from_user, recieved_at, opened));
