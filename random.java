class random{
  public static int randint(int min, int max) {
    return (int)((Math.random() * (max - min + 1)) + min);
  }
}
