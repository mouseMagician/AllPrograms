from bs4 import BeautifulSoup


def total_cost(cost_list):
    print(f'Total steam wishlist cost of: ${round(sum(cost_list), 2)}')


def sorted_rank(dict_costs):
    print('Wishlist sorted by rank:')
    for key, value in dict_costs.items():
        print(key, ':', value)


def cost_ascending(dict_costs):
    print('Wishlist sorted by cost (ascending):')
    sorted_dict = dict(sorted(dict_costs.items(), key=lambda x: x[1]))
    for key, value in sorted_dict.items():
        print(key, ':', value)


def cost_descending(dict_costs):
    print('Wishlist sorted by cost (descending):')
    sorted_decreasing = dict(sorted(dict_costs.items(), key=lambda x: x[1], reverse=True))
    for key, value in sorted_decreasing.items():
        print(key, ':', value)


def create_dict(title, cost):
    dict_costs = {}
    for index, value in enumerate(cost):
        dict_costs[title[index]] = value
    return dict_costs


def menu():
    print('[1] Print the total cost of the wishlist')
    print('[2] Print the wishlist sorted by rank')
    print('[3] Print the wishlist by ascending cost')
    print('[4] Print the wishlist by descending cost')
    print('[5] Exit')


def main():
    file = open('D:/Desktop/steam_data.txt', 'r')
    soup = BeautifulSoup(file, 'html.parser')
    # print(soup.prettify())

    cost = [float(i.string[3:]) for i in soup.find_all(class_='discount_final_price')]
    titles = [i.string[6:-5] for i in soup.find_all(class_='title')]

    ranked_dict = create_dict(titles, cost)

    while True:
        print('\nSelect an option:')
        menu()
        option = int(input())
        if option == 1:
            total_cost(cost)
            input('\nPress enter to continue: ')
        elif option == 2:
            sorted_rank(ranked_dict)
            input('\nPress enter to continue: ')
        elif option == 3:
            cost_ascending(ranked_dict)
            input('\nPress enter to continue: ')
        elif option == 4:
            cost_descending(ranked_dict)
            input('\nPress enter to continue: ')
        elif option == 5:
            break
        else:
            print('Error, please select a correct option')


if __name__ == '__main__':
    main()
