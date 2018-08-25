package com.example.alumnos.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;


public class GeneroMusicalDAO {

    private DbHelper _dbHelper;

    public GeneroMusicalDAO(Context c) {
        _dbHelper = new DbHelper(c);
    }

    public void insertar(String titulo, String descripcion) throws DAOException {
        Log.i("GeneroMusicalDAO", "insertar()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();
        try {
            String[] args = new String[]{titulo, descripcion};
            db.execSQL("INSERT INTO genero(titulo, descripcion) VALUES(?,?)", args);
            Log.i("GeneroMusicalDAO", "Se insertó");
        } catch (Exception e) {
            throw new DAOException("GeneroMusicalDAO: Error al insertar: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public GeneroMusical obtener() throws DAOException {
        Log.i("GeneroMusicalDAO", "obtener()");
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        GeneroMusical modelo = new GeneroMusical();
        try {
            Cursor c = db.rawQuery("select id, titulo, descripcion from genero", null);
            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    String titulo = c.getString(c.getColumnIndex("titulo"));
                    String descripcion = c.getString(c.getColumnIndex("descripcion"));

                    modelo.setId(id);
                    modelo.setTitulo(titulo);
                    modelo.setDescripcion(descripcion);

                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw new DAOException("GeneroMusicalDAO: Error al obtener: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return modelo;
    }

    public ArrayList<GeneroMusical> buscar(String criterio) throws DAOException {
        Log.i("GeneroMusicalDAO", "buscar()");
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        ArrayList<GeneroMusical> lista = new ArrayList<GeneroMusical>();
        try {
            Cursor c = db.rawQuery("select id, titulo, descripcion from genero where titulo like '%"+criterio+"%' or descripcion like '%"+criterio+"%'", null);

            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    String titulo = c.getString(c.getColumnIndex("titulo"));
                    String descripcion = c.getString(c.getColumnIndex("descripcion"));

                    GeneroMusical modelo = new GeneroMusical();
                    modelo.setId(id);
                    modelo.setTitulo(titulo);
                    modelo.setDescripcion(descripcion);

                    lista.add(modelo);
                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw new DAOException("GeneroMusicalDAO: Error al obtener: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return lista;
    }

    public void eliminar(int id) throws DAOException {
        Log.i("GeneroMusicalDAO", "eliminar()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();

        try {
            String[] args = new String[]{String.valueOf(id)};
            db.execSQL("DELETE FROM genero WHERE id=?", args);
        } catch (Exception e) {
            throw new DAOException("GeneroMusicalDAO: Error al eliminar: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public void eliminarTodos() throws DAOException {
        Log.i("GeneroMusicalDAO", "eliminarTodos()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM genero");
        } catch (Exception e) {
            throw new DAOException("GeneroMusicalDAO: Error al eliminar todos: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

}
