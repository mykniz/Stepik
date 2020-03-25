import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Animal[] animals = new Animal[]{
                new Animal("pig"),
                new Animal("cow"),
        };

        String fileName = "serializedAnimals.txt";

        serializeAnimalsToFile(animals, fileName);

        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] buff = fileInputStream.readAllBytes();
        fileInputStream.close();

        System.out.println(Arrays.toString(deserializeAnimalArray(buff)));

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] deserializedAnimals = new Animal[]{};
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int animalCount = objectInputStream.readInt();
            deserializedAnimals = new Animal[animalCount];
            for (int i = 0; i < animalCount; i++) {
                Object animal = objectInputStream.readObject();
                deserializedAnimals[i] = (Animal) animal;
            }
        } catch (NegativeArraySizeException | ClassNotFoundException | StreamCorruptedException | EOFException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deserializedAnimals;
    }


    public static void serializeAnimalsToFile(Animal[] animals, String fileName) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(fileName);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeInt(animals.length);
            for (Animal animal : animals) {
                objectOutputStream.writeObject(animal);
            }
            objectOutputStream.flush();
        }
    }
}



