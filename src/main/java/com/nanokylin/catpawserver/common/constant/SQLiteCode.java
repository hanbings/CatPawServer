package com.nanokylin.catpawserver.common.constant;

public class SQLiteCode {
    public static final int SQLITE_OK = 0;   /* 成功 | Successful result */
    public static final int SQLITE_ERROR = 1;   /* SQL错误 或 丢失数据库 | SQL error or missing database */
    public static final int SQLITE_INTERNAL = 2;   /* SQLite 内部逻辑错误 | Internal logic error in SQLite */
    public static final int SQLITE_PERM = 3;   /* 拒绝访问 | Access permission denied */
    public static final int SQLITE_ABORT = 4;   /* 回调函数请求取消操作 | Callback routine requested an abort */
    public static final int SQLITE_BUSY = 5;   /* 数据库文件被锁定 | The database file is locked */
    public static final int SQLITE_LOCKED = 6;  /* 数据库中的一个表被锁定 | A table in the database is locked */
    public static final int SQLITE_NOMEM = 7;/* 某次 malloc() 函数调用失败 | A malloc() failed */
    public static final int SQLITE_READONLY = 8;  /* 尝试写入一个只读数据库 | Attempt to write a readonly database */
    public static final int SQLITE_INTERRUPT = 9; /* 操作被 sqlite3_interupt() 函数中断 | Operation terminated by ite3_interrupt() */
    public static final int SQLITE_IOERR = 10;/* 发生某些磁盘 I/O 错误 | Some kind of disk I/O error occurred */
    public static final int SQLITE_CORRUPT = 11; /* 数据库磁盘映像不正确 | The database disk image is malformed */
    public static final int SQLITE_NOTFOUND = 12; /* sqlite3_file_control() 中出现未知操作数 | Unknown opcode in ite3_file_control() */
    public static final int SQLITE_FULL = 13; /* 因为数据库满导致插入失败 | Insertion failed because database is full */
    public static final int SQLITE_CANTOPEN = 14;  /* 无法打开数据库文件 | Unable to open the database file */
    public static final int SQLITE_PROTOCOL = 15;  /* 数据库锁定协议错误 | Database lock protocol error */
    public static final int SQLITE_EMPTY = 16;/* 数据库为空 | Database is empty */
    public static final int SQLITE_SCHEMA = 17;/* 数据结构发生改变 | The database schema changed */
    public static final int SQLITE_TOOBIG = 18;/* 字符串或二进制数据超过大小限制 | String or BLOB exceeds size limit */
    public static final int SQLITE_CONSTRAINT = 19;  /* 由于约束违例而取消 | Abort due to constraint violation */
    public static final int SQLITE_MISMATCH = 20;/* 数据类型不匹配 | Data type mismatch */
    public static final int SQLITE_MISUSE = 21;/* 不正确的库使用 | Library used incorrectly */
    public static final int SQLITE_NOLFS = 22;   /* 使用了操作系统不支持的功能 | Uses OS features not supported on host */
    public static final int SQLITE_AUTH = 23;  /* 授权失败 | Authorization denied */
    public static final int SQLITE_FORMAT = 24;   /* 附加数据库格式错误 | Auxiliary database format error */
    public static final int SQLITE_RANGE = 25; /* 传递给sqlite3_bind()的第二个参数超出范围 | 2nd parameter to sqlite3_bind out of range */
    public static final int SQLITE_NOTADB = 26; /* 被打开的文件不是一个数据库文件 | File opened that is not a database file */
    public static final int SQLITE_ROW = 100;/* sqlite3_step() 已经产生一个行结果 | sqlite3_step() has another row ready */
    public static final int SQLITE_DONE = 101;/* sqlite3_step() 完成执行操作 | sqlite3_step() has finished executing */
}
