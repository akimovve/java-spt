package ru.mirea;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ListSync<E> implements List<E> {
    private Semaphore semaphore = new Semaphore(1, true);
    private volatile List<E> list = new ArrayList<>();

    @Override
    public boolean add(E e) {
        boolean added = false;
        try {
            semaphore.acquire();
            added = list.add(e);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return added;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        try {
            semaphore.acquire();
            removed = list.remove(o);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return removed;
    }

    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = list.size();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        try {
            semaphore.acquire();
            isEmpty = list.isEmpty();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        try {
            semaphore.acquire();
            contains = list.contains(o);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return contains;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> itr = null;
        try {
            semaphore.acquire();
            itr = list.iterator();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return itr;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[]{};
        try {
            semaphore.acquire();
            obj = list.toArray();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return obj;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] obj = new Object[]{};
        try {
            semaphore.acquire();
            obj = list.toArray(a);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return (T[]) obj;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsAll = false;
        try {
            semaphore.acquire();
            containsAll = list.containsAll(c);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return containsAll;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean addAll = false;
        try {
            semaphore.acquire();
            addAll = list.addAll(c);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return addAll;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean addAll = false;
        try {
            semaphore.acquire();
            addAll = list.addAll(index, c);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return addAll;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removeAll = false;
        try {
            semaphore.acquire();
            removeAll = list.removeAll(c);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return removeAll;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean retainAll = false;
        try {
            semaphore.acquire();
            retainAll = list.retainAll(c);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return retainAll;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public E get(int index) {
        Object obj = null;
        try {
            semaphore.acquire();
            obj = list.get(index);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return (E) obj;
    }

    @Override
    public E set(int index, E element) {
        Object obj = null;
        try {
            semaphore.acquire();
            obj = list.set(index, element);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return (E) obj;
    }

    @Override
    public void add(int index, E element) {
        try {
            semaphore.acquire();
            list.add(index, element);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public E remove(int index) {
        Object obj = null;
        try {
            semaphore.acquire();
            obj = list.remove(index);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return (E) obj;
    }

    @Override
    public int indexOf(Object o) {
        int idx = -1;
        try {
            semaphore.acquire();
            idx = list.indexOf(o);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return idx;
    }

    @Override
    public int lastIndexOf(Object o) {
        int idx = -1;
        try {
            semaphore.acquire();
            idx = list.lastIndexOf(o);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return idx;
    }

    @Override
    public ListIterator<E> listIterator() {
        ListIterator<E> listItr = null;
        try {
            semaphore.acquire();
            listItr = list.listIterator();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return listItr;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> listItr = null;
        try {
            semaphore.acquire();
            listItr = list.listIterator(index);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return listItr;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> subList = null;
        try {
            semaphore.acquire();
            subList = list.subList(fromIndex, toIndex);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        } finally {
            semaphore.release();
        }
        return subList;
    }
}
