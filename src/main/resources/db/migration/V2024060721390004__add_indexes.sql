-- Add indexes
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_balances_user_id ON balances(user_id);
CREATE INDEX idx_expenses_user_id ON expenses(user_id);