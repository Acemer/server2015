package ru.nordwest.nord.util;

/**
 * Простой класс для хранения координат блока
 * @author Dark32
 */
public class BlockCoord {
        public final int x;
        public final int y;
        public final int z;
        public final int ID;

        public BlockCoord(int x, int y, int z) {
                this.x = x;
                this.y = y;
                this.z = z;
                this.ID = 0;
        }

        public BlockCoord(int x, int y, int z, int ID) {
                this.x = x;
                this.y = y;
                this.z = z;
                this.ID = ID;
        }

        @Override
        public int hashCode() {
                String tmp = Integer.valueOf(x).toString().concat(Integer.valueOf(y).toString()).concat(Integer.valueOf(z).toString());
                int hash = tmp.hashCode();
                return hash;
        }

        @Override
        public boolean equals(Object arg0) {
                return arg0.hashCode() == this.hashCode();
        }
}
