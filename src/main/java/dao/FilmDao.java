package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Film;

public class FilmDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("nayana");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveMovie(Film film) {
		
		transaction.begin();
		manager.persist(film);
		transaction.commit();
		
	}

	public List<Film> fetchFilm() {
		
		return manager.createQuery("select x from Film x").getResultList();
	}

	public List<Film> fetchFilmById(int id) {
		return manager.createQuery("select x from Film x where id = ?1").setParameter(1, id).getResultList();
	}

	public List<Film> fetchFilmByRating(double rating) {
		return manager.createQuery("select x from Film x where rating = ?1").setParameter(1, rating).getResultList();
	}

	public List<Film> fetchFilmByName(String name) {
	       return manager.createQuery("select x from Film x where name=?1").setParameter(1, name).getResultList();

	}

	public List<Film> fetchFilmByLanguage(String language) {
	    return manager.createQuery("select x from Film x where language=?1").setParameter(1, language).getResultList();

	}

	public List<Film> fetchFilmByGenre(String genre) {
	     return manager.createQuery("select x from Film x where genre=?1").setParameter(1, genre).getResultList();

	}



}
