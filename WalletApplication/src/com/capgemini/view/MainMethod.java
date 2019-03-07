package com.capgemini.view;

import java.math.BigDecimal;
import java.util.Scanner;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InsufficientWalletBalanceException;
import com.capgemini.exception.InvalidMobileNumberException;
import com.capgemini.repo.WalletRepo;
import com.capgemini.repo.WalletRepoImpl;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImpl;

public class MainMethod 
{

	public static void main(String[] args) throws Exception
	{

		WalletService walletservice=new WalletServiceImpl(new WalletRepoImpl());
		
		
Scanner scanner=new Scanner(System.in);
		
		while(true)																		//Infinite loop to show menu
		{
			System.out.println("Choose option: ");
			System.out.println("1. Create account");
			System.out.println("2. Show balance");
			System.out.println("3. Deposit Amount");
			System.out.println("4. Withdraw ampount");
			System.out.println("5. Fund transfer");
			System.out.println("6. Exit");
			
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)																//Switch case to choose option
			{
			case 1: System.out.println("Enter name: ");
					String name=scanner.nextLine();
					System.out.println("Enter mobile number: ");
					String mob=scanner.nextLine();
					System.out.println("Enter amount:");
					BigDecimal amount=scanner.nextBigDecimal();
					Customer customer=new Customer();
					customer.setName(name);
					customer.setMobileno(mob);
					Wallet wallet=new Wallet();
					wallet.setBalance(amount);
					customer.setWallet(wallet);
					try
					{
						System.out.println(walletservice.createAccount(name, mob, wallet));
						System.out.println("Account created");
						System.out.println("-----------------------------");
						break;
					}
					catch(DuplicateMobileNumberException e)
					{
						System.err.println("Mobile number already exists");
					}

			case 2: System.out.println("Enter mobile number: ");
					String mobileno=scanner.nextLine();
					try
					{
						System.out.println("Current balance: "+walletservice.showBalance(mobileno));
						System.out.println("-----------------------------");
						break;
					}
					catch(InvalidMobileNumberException e)
					{
						System.err.println("Invalid Mobile Number");
					}
					
			case 3: System.out.println("Enter mobile number: ");
					String mobil=scanner.nextLine();
					System.out.println("Enter amount");
					BigDecimal depAmpount=scanner.nextBigDecimal();
					try
					{
						System.out.println("Amount deposited, current status: "+walletservice.depositAmount(mobil, depAmpount));
						System.out.println("-----------------------------");
						break;
					}
					catch(InvalidMobileNumberException e)
					{
						System.err.println("Invalid Mobile Number");
					}
			case 4: System.out.println("Enter mobile number: ");
					String withMobile=scanner.nextLine();
					System.out.println("Enter amount");
					BigDecimal withAmpount=scanner.nextBigDecimal();
				
						try
						{
							System.out.println("Amount withdrawn, current status: "+walletservice.withdrawAmount( withMobile, withAmpount));
							System.out.println("-----------------------------");
							break;
						}
						catch(InvalidMobileNumberException e)
						{
							System.err.println("Invalid Mobile Number");
						}
						catch(InsufficientWalletBalanceException e)
						{
							System.err.println("Insufficient Wallet Balance");
						}
						
			case 5: System.out.println("Enter source mobile number: ");
					String sMob=scanner.nextLine();
					System.out.println("Enter target mobile number: ");
					String tMob=scanner.nextLine();
					System.out.println("Enter amount: ");
					BigDecimal samount=scanner.nextBigDecimal();
					try
					{
						System.out.println("Fund transfered successfully: "+walletservice.fundTransfer(sMob, tMob, samount));
						System.out.println("-----------------------------");
						break;
					}
					catch(InvalidMobileNumberException e)
					{
						System.err.println("Invalid Mobile Number");
					}
					catch(InsufficientWalletBalanceException e)
					{
						System.err.println("Insufficient Wallet Balance");
					}
			case 6: System.exit(0);
					break;
					
			}
		}
	}

}
