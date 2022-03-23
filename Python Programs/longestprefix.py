def longest_common_prefix(list): # O(n2)
	length = len(list)
	if (length == 0 or "" in list): return ""
	for i in range(length):
		for j in range(length):
			if ((list[0])[i] != (list[j])[i]) or i == len(list[j]):
				return (list[0])[:i]
	return 0

def prefix(list): # O(N)
	if "" in list or list == []: return ""
	preix = list[0]
	for i in range(1,len(list)):
		while(preix != ""):
			try:
				if str.index(str(list[i]),preix) == 0:
					break
				else:
					preix = preix[:-1]
			except:
				preix = preix[:-1]
	return preix


def main():
	x = ["flower","flow","flight"]
	print("Longest common prefix: " + longest_common_prefix(x))
	print("Longest common prefix: " + prefix(x))

if __name__ == "__main__":
	main()