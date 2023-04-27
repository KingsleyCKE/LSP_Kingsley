package org.howard.edu.lsp.finals.problem;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class SongsDatabaseTest {

    @Test
    void testAddSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");

        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertTrue(jazzSongs.contains("Always There"));
    }

    @Test
    void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");

        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertEquals(1, jazzSongs.size());
        assertTrue(jazzSongs.contains("Always There"));
    }

    @Test
    void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");

        assertEquals("Rap", db.getGenreOfSong("Savage"));
        assertEquals("Rap", db.getGenreOfSong("Gin and Juice"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));
    }
}
