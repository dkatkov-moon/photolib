mod db;
use crate::db::Photo;

fn main() {
    let photo = Photo::new("C:/temp/1.png".to_string());
    photo.insert().unwrap();
}
