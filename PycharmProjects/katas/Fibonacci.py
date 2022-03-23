x = [0, 1]
print("How many numbers would you like to go up to?:", end=" ")
nums = int(input())
for i in range(2, nums):
    x.append((x[i-2]+x[i-1]))
print(x)
print("The 100th number is:" + str(x[99]))