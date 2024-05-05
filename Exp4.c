#include <stdio.h>
#include <math.h>

int main() {
    int p, q, n, phi, d, e, i, j, CT, PT;

    printf("Enter First Prime number: ");
    scanf("%d", &p);
    printf("Enter Second Prime number: ");
    scanf("%d", &q);

    n = p * q;
    phi = (p - 1) * (q - 1);

    printf("Choose e such that it is relatively prime to %d: ", phi);
    scanf("%d", &e);

    for (d = 1; d < phi; d++) {
        if (((d * e) % phi) == 1) 
            break;
    }

    printf("Enter the plaintext character: ");
    scanf("%d", &PT);

    // Encryption
    CT = 1;
    for (i = 0; i < e; i++) 
        CT = (CT * PT) % n;

    printf("After Encryption: %d\n", CT);

    // Decryption
    PT = 1;
    for (i = 0; i < d; i++)
        PT = (PT * CT) % n;

    printf("After Decryption: %d\n", PT);

    return 0;
}
