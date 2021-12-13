use rusqlite::{Connection, Result, params};

#[derive(Debug)]
pub struct Photo {
    path: String
}

impl Photo {
    pub fn new(path: String) -> Self {
        Photo {path}
    }

    pub fn insert(&self) -> Result<i64> {
        let conn = Connection::open("/Users/dremax/portfolio/sqlite/example.db")?;
        conn.execute(
            "INSERT INTO photos (path) VALUES (?1)", 
            params![self.path],
        )?;
        Ok(conn.last_insert_rowid())
    }
}

