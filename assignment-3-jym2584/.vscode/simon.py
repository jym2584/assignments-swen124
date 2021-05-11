def main():
  num = int(input("num: "))
  characters = dict()

  for _ in range(0, num):
    name_language = input().split(" ")
    if name_language[0] not in characters:
      characters[name_language[0]] = name_language[1:]

  print(characters)



main()