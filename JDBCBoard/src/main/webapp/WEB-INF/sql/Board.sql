[CMD]
C:\Users\Administrator>sqlplus conn as sysdba
[SQLPLUS]
SQL> create user jdbcboard identified by jdbcboard;
SQL> grant connect, resource to jdbcboard;
SQL> conn jdbcboard/jdbcboard;