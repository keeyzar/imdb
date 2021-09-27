package de.keeyzar.checkimdb.imdbclone.errors;

/**
 * Base exception for all upcoming errors; use controller advice and so on catching these runtime exceptions
 * this is done on purpose, or we need to handle all these exceptions through the whole call stack,
 * this is unpleasant and obstructs readability!
 */
public class IMDBApiError extends RuntimeException {
}
