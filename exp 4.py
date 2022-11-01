def CharCount(A):
    A.insert(0, len(A)+1)
    print("Character Count: ", A)


def BitStuff(A):
    for i in range((len(A)-4)):
        if A[i] == A[i + 1] == A[i + 2] == A[i + 3] == A[i + 4] == "1":
            A.insert((i + 5), 0)
            print("Stuffed: ", A)


def ByteStuff(A):
    # ESC(E) Flag(F)
    for i in range(0, len(A)):
        if A[i] == 'E':
            A.insert(i, "E")
            break
    for j in range(0, len(A)):
        if A[j] == 'F':
            A.insert(j, "E")
            break

    A.insert(0, "F")
    A.append("F")
    print('The Frame after Processing is: ', A)


def PDV(A):
    for h in range(0, len(A)):
        if A[h] == "0":
            A.insert(h, '01')
            break
    for k in range(0, len(A)):
        if A[k] == "1":
            A.insert(k, '10')
            break

    print('The Frame after Processing is: ', A)


print("\nEnter 1 for Character Count\nEnter 2 for Byte Stuffing (Flag: 1010 ESC: 1111)\nEnter 3 for Bit Stuffing\nEnter 4 for Physical Data Violation")
choice = int(input("Enter your choice: "))
A = list(input("\nEnter the Data Stream: "))
print("Current Data Stream: ", A)
# print("X", byte)
if choice == 1:
    print()
    CharCount(A)
elif choice == 2:
    print()
    ByteStuff(A)
elif choice == 3:
    print()
    BitStuff(A)
elif choice == 4:
    print()
    PDV(A)
else:
    print("Wrong choice")
