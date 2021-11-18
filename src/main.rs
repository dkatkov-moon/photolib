use rusqlite::{Connection, Result};

fn main() -> Result<()> {
    let conn = Connection::open("/Users/dremax/portfolio/sqlite/example.db")?;

    conn.execute(
        "create table if not exists photos (
                id integer primary key,
                path text not null
        )", [])?;
    
    Ok(())
}
